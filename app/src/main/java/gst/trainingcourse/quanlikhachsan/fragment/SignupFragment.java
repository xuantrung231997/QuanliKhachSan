package gst.trainingcourse.quanlikhachsan.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import gst.trainingcourse.quanlikhachsan.R;
import gst.trainingcourse.quanlikhachsan.dao.UserDAO;
import gst.trainingcourse.quanlikhachsan.model.User;

public class SignupFragment extends Fragment {
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtnDangKy;
    private TextView mTxtMember;

    private final View.OnClickListener mTxtMemberClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            initFragment();
        }
    };

    private final View.OnClickListener mBtnDangKyClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            UserDAO userDAO = new UserDAO(getContext());
            User user = new User();
            user.setEmail(mEtEmail.getText().toString());
            user.setPassword(mEtPassword.getText().toString());
            if (!user.getPassword().isEmpty() && !user.getEmail().isEmpty()) {
                boolean kiemtra = userDAO.addUser(user);
                if (kiemtra) {
                    Toast.makeText(getActivity(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initFragment();
                        }
                    }, 2000);
                } else {
                    Toast.makeText(getActivity(), "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                }
            } else Toast.makeText(getActivity(), "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup_fragment, container, false);
        initView(view);
        initAction();
        return view;
    }

    private void initAction() {
        mBtnDangKy.setOnClickListener(mBtnDangKyClick);
        mTxtMember.setOnClickListener(mTxtMemberClick);
    }

    private void initView(View view) {
        mEtEmail = view.findViewById(R.id.etEmailDK);
        mEtPassword = view.findViewById(R.id.etPasswordDK);
        mBtnDangKy = view.findViewById(R.id.btnSignUpDK);
        mTxtMember = view.findViewById(R.id.txtMemberDK);
    }

    private void initFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.lnDangNhapActivity, loginFragment);
        fragmentTransaction.commit();
    }
}
