package com.example.graduationproject;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.graduationproject.databinding.CardDesignBindingImpl;
import com.example.graduationproject.databinding.CartItemDesignBindingImpl;
import com.example.graduationproject.databinding.CategoriesCardDesignBindingImpl;
import com.example.graduationproject.databinding.FragmentCartBindingImpl;
import com.example.graduationproject.databinding.FragmentDetailsBindingImpl;
import com.example.graduationproject.databinding.FragmentHomeBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CARDDESIGN = 1;

  private static final int LAYOUT_CARTITEMDESIGN = 2;

  private static final int LAYOUT_CATEGORIESCARDDESIGN = 3;

  private static final int LAYOUT_FRAGMENTCART = 4;

  private static final int LAYOUT_FRAGMENTDETAILS = 5;

  private static final int LAYOUT_FRAGMENTHOME = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.graduationproject.R.layout.card_design, LAYOUT_CARDDESIGN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.graduationproject.R.layout.cart_item_design, LAYOUT_CARTITEMDESIGN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.graduationproject.R.layout.categories_card_design, LAYOUT_CATEGORIESCARDDESIGN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.graduationproject.R.layout.fragment_cart, LAYOUT_FRAGMENTCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.graduationproject.R.layout.fragment_details, LAYOUT_FRAGMENTDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.graduationproject.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CARDDESIGN: {
          if ("layout/card_design_0".equals(tag)) {
            return new CardDesignBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for card_design is invalid. Received: " + tag);
        }
        case  LAYOUT_CARTITEMDESIGN: {
          if ("layout/cart_item_design_0".equals(tag)) {
            return new CartItemDesignBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for cart_item_design is invalid. Received: " + tag);
        }
        case  LAYOUT_CATEGORIESCARDDESIGN: {
          if ("layout/categories_card_design_0".equals(tag)) {
            return new CategoriesCardDesignBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for categories_card_design is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCART: {
          if ("layout/fragment_cart_0".equals(tag)) {
            return new FragmentCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTDETAILS: {
          if ("layout/fragment_details_0".equals(tag)) {
            return new FragmentDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_details is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(9);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "adapter");
      sKeys.put(2, "cartFragment");
      sKeys.put(3, "categoriesAdapter");
      sKeys.put(4, "detailsFragment");
      sKeys.put(5, "food");
      sKeys.put(6, "foodsInCart");
      sKeys.put(7, "homeFragment");
      sKeys.put(8, "orderAmountVar");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/card_design_0", com.example.graduationproject.R.layout.card_design);
      sKeys.put("layout/cart_item_design_0", com.example.graduationproject.R.layout.cart_item_design);
      sKeys.put("layout/categories_card_design_0", com.example.graduationproject.R.layout.categories_card_design);
      sKeys.put("layout/fragment_cart_0", com.example.graduationproject.R.layout.fragment_cart);
      sKeys.put("layout/fragment_details_0", com.example.graduationproject.R.layout.fragment_details);
      sKeys.put("layout/fragment_home_0", com.example.graduationproject.R.layout.fragment_home);
    }
  }
}
