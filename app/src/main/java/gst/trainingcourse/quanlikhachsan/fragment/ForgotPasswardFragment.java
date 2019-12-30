package gst.trainingcourse.quanlikhachsan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import gst.trainingcourse.quanlikhachsan.R;

public class ForgotPasswardFragment extends Fragment {
    private ImageButton mBtnBack;

    private final View.OnClickListener mBtnBackClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getActivity().onBackPressed();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forgot_password_fragment, container, false);
        initView(view);
        initAction();
        return view;
    }

    private void initAction() {
        mBtnBack.setOnClickListener(mBtnBackClick);
    }

    private void initView(View view) {
        mBtnBack = view.findViewById(R.id.btnBackForgotPassword);
    }
}
