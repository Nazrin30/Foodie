// Generated by view binder compiler. Do not edit!
package com.example.graduationproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.graduationproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button;

  @NonNull
  public final TextView goToRegister;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final EditText passwordText;

  @NonNull
  public final EditText usernameText;

  private FragmentLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button button,
      @NonNull TextView goToRegister, @NonNull ImageView imageView2, @NonNull EditText passwordText,
      @NonNull EditText usernameText) {
    this.rootView = rootView;
    this.button = button;
    this.goToRegister = goToRegister;
    this.imageView2 = imageView2;
    this.passwordText = passwordText;
    this.usernameText = usernameText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.goToRegister;
      TextView goToRegister = ViewBindings.findChildViewById(rootView, id);
      if (goToRegister == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.passwordText;
      EditText passwordText = ViewBindings.findChildViewById(rootView, id);
      if (passwordText == null) {
        break missingId;
      }

      id = R.id.usernameText;
      EditText usernameText = ViewBindings.findChildViewById(rootView, id);
      if (usernameText == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ConstraintLayout) rootView, button, goToRegister, imageView2,
          passwordText, usernameText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
