package com.example.graduationproject.databinding;
import com.example.graduationproject.R;
import com.example.graduationproject.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentDetailsBindingImpl extends FragmentDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView3, 4);
        sViewsWithIds.put(R.id.view3, 5);
        sViewsWithIds.put(R.id.description, 6);
        sViewsWithIds.put(R.id.btnAddToCart, 7);
        sViewsWithIds.put(R.id.orderAmountBack, 8);
        sViewsWithIds.put(R.id.btnAdd, 9);
        sViewsWithIds.put(R.id.btnRemove, 10);
        sViewsWithIds.put(R.id.imageView9, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[9]
            , (android.widget.Button) bindings[7]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[8]
            , (android.view.View) bindings[5]
            );
        this.foodNameDetails.setTag(null);
        this.foodPriceDetails.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.orderAmount.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.food == variableId) {
            setFood((com.example.graduationproject.data.entity.Foods) variable);
        }
        else if (BR.detailsFragment == variableId) {
            setDetailsFragment((com.example.graduationproject.ui.fragments.DetailsFragment) variable);
        }
        else if (BR.orderAmountVar == variableId) {
            setOrderAmountVar((java.lang.Integer) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFood(@Nullable com.example.graduationproject.data.entity.Foods Food) {
        this.mFood = Food;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.food);
        super.requestRebind();
    }
    public void setDetailsFragment(@Nullable com.example.graduationproject.ui.fragments.DetailsFragment DetailsFragment) {
        this.mDetailsFragment = DetailsFragment;
    }
    public void setOrderAmountVar(@Nullable java.lang.Integer OrderAmountVar) {
        this.mOrderAmountVar = OrderAmountVar;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.orderAmountVar);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String foodName = null;
        com.example.graduationproject.data.entity.Foods food = mFood;
        int foodPrice = 0;
        int androidxDatabindingViewDataBindingSafeUnboxOrderAmountVar = 0;
        java.lang.String javaLangStringPriceStringValueOfFoodPriceJavaLangString = null;
        java.lang.Integer orderAmountVar = mOrderAmountVar;
        java.lang.String stringValueOfFoodPrice = null;
        java.lang.String javaLangStringPriceStringValueOfFoodPrice = null;
        java.lang.String stringValueOfOrderAmountVar = null;

        if ((dirtyFlags & 0x9L) != 0) {



                if (food != null) {
                    // read food.name
                    foodName = food.getName();
                    // read food.price
                    foodPrice = food.getPrice();
                }


                // read String.valueOf(food.price)
                stringValueOfFoodPrice = java.lang.String.valueOf(foodPrice);


                // read ("Price: ") + (String.valueOf(food.price))
                javaLangStringPriceStringValueOfFoodPrice = ("Price: ") + (stringValueOfFoodPrice);


                // read (("Price: ") + (String.valueOf(food.price))) + ("$")
                javaLangStringPriceStringValueOfFoodPriceJavaLangString = (javaLangStringPriceStringValueOfFoodPrice) + ("$");
        }
        if ((dirtyFlags & 0xcL) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar)
                androidxDatabindingViewDataBindingSafeUnboxOrderAmountVar = androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar);


                // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar))
                stringValueOfOrderAmountVar = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxOrderAmountVar);
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.foodNameDetails, foodName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.foodPriceDetails, javaLangStringPriceStringValueOfFoodPriceJavaLangString);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.orderAmount, stringValueOfOrderAmountVar);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): food
        flag 1 (0x2L): detailsFragment
        flag 2 (0x3L): orderAmountVar
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}