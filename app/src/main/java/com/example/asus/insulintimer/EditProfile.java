
package com.example.asus.insulintimer;

        import android.os.Bundle;
        import android.os.PersistableBundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

/**
 * Created by Mharjorie Sandel on 10/03/2018.
 */

public class EditProfile extends Fragment {
    private Button cancel, upload;
    private EditText name, bday, email, height, weight, min, max;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivity().setTitle("Edit Profile");
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        //setContentView(R.layout.edit_profile);
        //back = (Button) findViewById(R.id.b_cancel);
        //upload = (Button) findViewById(R.id.b_upload);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_profile, container, false);
        getActivity().setTitle("Edit Profile");
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.edit_profile);
        cancel = (Button) view.findViewById(R.id.b_cancel);
        upload = (Button) view.findViewById(R.id.b_upload);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fM = getActivity().getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                Profile h= new Profile();
                fT.replace(R.id.frame_layout,h);
                fT.commit();
            }
        });
        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.edit_menu, menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_save:
                FragmentManager fM = getActivity().getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                Profile h= new Profile();
                fT.replace(R.id.frame_layout,h);
                fT.commit();
                Toast.makeText(getActivity(), "Edit!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

