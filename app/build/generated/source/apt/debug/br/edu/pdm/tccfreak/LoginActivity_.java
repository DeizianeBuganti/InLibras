//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.1.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package br.edu.pdm.tccfreak;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.builder.PostActivityStarter;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class LoginActivity_
    extends LoginActivity
    implements HasViews, OnViewChangedListener
{
    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(R.layout.activity_login);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static LoginActivity_.IntentBuilder_ intent(Context context) {
        return new LoginActivity_.IntentBuilder_(context);
    }

    public static LoginActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new LoginActivity_.IntentBuilder_(fragment);
    }

    public static LoginActivity_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new LoginActivity_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        this.edtLogin = ((EditText) hasViews.findViewById(R.id.edtLogin));
        this.edtSenha = ((EditText) hasViews.findViewById(R.id.edtSenha));
        this.btnLogin = ((ImageButton) hasViews.findViewById(R.id.btnLogin));
        this.btnSair = ((ImageButton) hasViews.findViewById(R.id.btnSair));
        this.btnCadastro = ((Button) hasViews.findViewById(R.id.btnCadastro));
        if (this.btnSair!= null) {
            this.btnSair.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    LoginActivity_.this.onClick(view);
                }
            }
            );
        }
        if (this.btnLogin!= null) {
            this.btnLogin.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    LoginActivity_.this.onClick(view);
                }
            }
            );
        }
        if (this.btnCadastro!= null) {
            this.btnCadastro.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    LoginActivity_.this.onClick(view);
                }
            }
            );
        }
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<LoginActivity_.IntentBuilder_>
    {
        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, LoginActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), LoginActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), LoginActivity_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public PostActivityStarter startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
                        fragment_.startActivityForResult(intent, requestCode, lastOptions);
                    } else {
                        fragment_.startActivityForResult(intent, requestCode);
                    }
                } else {
                    if (context instanceof Activity) {
                        Activity activity = ((Activity) context);
                        ActivityCompat.startActivityForResult(activity, intent, requestCode, lastOptions);
                    } else {
                        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
                            context.startActivity(intent, lastOptions);
                        } else {
                            context.startActivity(intent);
                        }
                    }
                }
            }
            return new PostActivityStarter(context);
        }
    }
}
