package com.rey.aplikasikeuangan3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();
    private ListView listUsers;
    private ProgressBar progressBar;
    private UserAdapter adapter;
    private ArrayList<User> users;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Inisialisasi komponen
        progressBar = view.findViewById(R.id.progressBar);
        listUsers = view.findViewById(R.id.lv_list);

        adapter = new UserAdapter(getContext());
        getListUsers();

        listUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getContext(), users.get(position).getName(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Clicked: " + users.get(position).getName());
            }
        });

        return view;
    }

    //API
    private void getListUsers() {
        progressBar.setVisibility(View.VISIBLE);
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://api.github.com/users";
        client.addHeader("Authorization", "client.addHeader(\"Authorization\", \"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\");");
        client.addHeader("User-Agent", "request");

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                progressBar.setVisibility(View.GONE);
                ArrayList<User> listUser = new ArrayList<>();
                String result = new String(responseBody);

                try {
                    JSONArray dataArray = new JSONArray(result);
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject dataJson = dataArray.getJSONObject(i);
                        String name = dataJson.getString("login");
                        String type = dataJson.getString("type");
                        String photo = dataJson.getString("avatar_url");

                        User user = new User();
                        user.setPhoto(photo);
                        user.setName(name);
                        user.setType(type);

                        listUser.add(user);
                    }

                    users = listUser;
                    adapter.setUsers(listUser);
                    listUsers.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                progressBar.setVisibility(View.GONE);
                String errorMessage;
                switch (statusCode) {
                    case 401:
                        errorMessage = statusCode + " : Bad Request";
                        break;
                    case 403:
                        errorMessage = statusCode + " : Forbidden";
                        break;
                    case 404:
                        errorMessage = statusCode + " : Not Found";
                        break;
                    default:
                        errorMessage = statusCode + " : " + error.getMessage();
                        break;
                }
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
