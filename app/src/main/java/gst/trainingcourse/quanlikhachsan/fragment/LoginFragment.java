package gst.trainingcourse.quanlikhachsan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import gst.trainingcourse.quanlikhachsan.R;
import gst.trainingcourse.quanlikhachsan.activity.HomeActivity;
import gst.trainingcourse.quanlikhachsan.dao.UserDAO;

public class LoginFragment extends Fragment {
    private TextView mTextForgotPassword;
    private EditText mEtTenDangNhap;
    private EditText mEtMatKhau;
    private Button mBtnDangNhap;
    private ImageButton mBtnBack;

    private final View.OnClickListener mBtnBackClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getActivity().onBackPressed();
        }
    };

    private final View.OnClickListener mTextForgotPasswordClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ForgotPasswardFragment forgotPasswardFragment = new ForgotPasswardFragment();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.lnDangNhapActivity, forgotPasswardFragment);
            fragmentTransaction.commit();
        }
    };
    private final View.OnClickListener mBtnDangNhapClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            UserDAO userDAO = new UserDAO(getContext());
            String tenUser = userDAO.checkLogin(mEtTenDangNhap.getText().toString(), mEtMatKhau.getText().toString());
            if (tenUser != null) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                intent.putExtra("tenUser", tenUser);
                startActivity(intent);
            } else
                Toast.makeText(getActivity(), "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_frgament, container, false);
        initView(view);
        initAction();
        return view;
    }

    private void initAction() {
        mTextForgotPassword.setOnClickListener(mTextForgotPasswordClick);
        mBtnDangNhap.setOnClickListener(mBtnDangNhapClick);
        mBtnBack.setOnClickListener(mBtnBackClick);
    }

    private void initView(View view) {
        mEtTenDangNhap = view.findViewById(R.id.etEmailLogin);
        mEtMatKhau = view.findViewById(R.id.etPasswordLogin);
        mBtnDangNhap = view.findViewById(R.id.btnLogin);
        mTextForgotPassword = view.findViewById(R.id.txtForgotPasswordLogin);
        mBtnBack = view.findViewById(R.id.btnBackLogin);
    }

}
