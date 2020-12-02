package com.codemountain.codeblog.retrofit;

import android.util.Log;

import com.codemountain.codeblog.dto.AuthResponse;
import com.codemountain.codeblog.dto.TokenRefreshDto;
import com.codemountain.codeblog.helper.UserManager;
import com.codemountain.codeblog.utils.SharedPref;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;
import xute.markdeditor.api.Api;

public class CustomAuthenticator implements Authenticator {

    private static final String TAG = "CustomAuthenticator";
    private static CustomAuthenticator INSTANCE;

    public static CustomAuthenticator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomAuthenticator();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public Request authenticate(@Nullable Route route, @NotNull Response response) throws IOException {

        if (responseCount(response) >= 2) {
            return null;
        }

        TokenRefreshDto tokenRefreshDto = new TokenRefreshDto(SharedPref.getSharedPrefInstance().getRefreshToken(),
                SharedPref.getSharedPrefInstance().getUserEmail());
        ApiInterface service = ServiceGenerator.createService(ApiInterface.class);
        Call<AuthResponse> authResponseCall = service.refreshAuth(tokenRefreshDto);
        retrofit2.Response<AuthResponse> execute = authResponseCall.execute();

        if (execute.isSuccessful()) {
            String authenticationToken = execute.body().getAuthenticationToken();
            String refreshToken = execute.body().getRefreshToken();
            String email = execute.body().getEmail();
            Long expiresAt = execute.body().getExpiresAt();

            UserManager.getInstance().saveAuthResponseInPref(authenticationToken, refreshToken, email, expiresAt);
            Log.e(TAG, "authenticate: "+ authenticationToken);
            return response.request().newBuilder()
                    .header("Authorization", authenticationToken)
                    .build();
        }
        else {
            Log.e(TAG, "authenticate: "+ "custom error");
            return null;
        }

    }

    private int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }
}
