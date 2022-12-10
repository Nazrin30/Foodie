package com.example.graduationproject.databinding;
import com.example.graduationproject.R;
import com.example.graduationproject.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CartItemDesignBindingImpl extends CartItemDesignBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView4, 4);
        sViewsWithIds.put(R.id.btnDelete, 5);
        sViewsWithIds.put(R.id.orderAmountBack, 6);
        sViewsWithIds.put(R.id.btnAdd, 7);
        sViewsWithIds.put(R.id.btnRemove, 8);
        sViewsWithIds.put(R.id.imageView9, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CartItemDesignBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private CartItemDesignBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[6]
            );
        this.cardItemName.setTag(null);
        this.cardItemPrice.setTag(null);
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
                mDirtyFlags = 0x4L;
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
        if (BR.foodsInCart == variableId) {
            setFoodsInCart((com.example.graduationproject.data.entity.FoodsInCart) variable);
        }
        else if (BR.orderAmountVar == variableId) {
            setOrderAmountVar((java.lang.Integer) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFoodsInCart(@Nullable com.example.graduationproject.data.entity.FoodsInCart FoodsInCart) {
        this.mFoodsInCart = FoodsInCart;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.foodsInCart);
        super.requestRebind();
    }
    public void setOrderAmountVar(@Nullable java.lang.Integer OrderAmountVar) {
        this.mOrderAmountVar = OrderAmountVar;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
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
        java.lang.String javaLangStringTotalStringValueOfFoodsInCartPriceOrderAmountVarJavaLangString = null;
        int foodsInCartPriceOrderAmountVar = 0;
        int androidxDatabindingViewDataBindingSafeUnboxOrderAmountVar = 0;
        com.example.graduationproject.data.entity.FoodsInCart foodsInCart = mFoodsInCart;
        java.lang.String stringValueOfFoodsInCartPriceOrderAmountVar = null;
        int foodsInCartPrice = 0;
        java.lang.String foodsInCartName = null;
        java.lang.Integer orderAmountVar = mOrderAmountVar;
        java.lang.String stringValueOfOrderAmountVar = null;
        java.lang.String javaLangStringTotalStringValueOfFoodsInCartPriceOrderAmountVar = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (foodsInCart != null) {
                    // read foodsInCart.price
                    foodsInCartPrice = foodsInCart.getPrice();
                }
                // read androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar)
                androidxDatabindingViewDataBindingSafeUnboxOrderAmountVar = androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar);


                // read (foodsInCart.price) * (androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar))
                foodsInCartPriceOrderAmountVar = (foodsInCartPrice) * (androidxDatabindingViewDataBindingSafeUnboxOrderAmountVar);


                // read String.valueOf((foodsInCart.price) * (androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar)))
                stringValueOfFoodsInCartPriceOrderAmountVar = java.lang.String.valueOf(foodsInCartPriceOrderAmountVar);


                // read ("Total: ") + (String.valueOf((foodsInCart.price) * (androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar))))
                javaLangStringTotalStringValueOfFoodsInCartPriceOrderAmountVar = ("Total: ") + (stringValueOfFoodsInCartPriceOrderAmountVar);


                // read (("Total: ") + (String.valueOf((foodsInCart.price) * (androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar))))) + ("$")
                javaLangStringTotalStringValueOfFoodsInCartPriceOrderAmountVarJavaLangString = (javaLangStringTotalStringValueOfFoodsInCartPriceOrderAmountVar) + ("$");
            if ((dirtyFlags & 0x6L) != 0) {

                    // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(orderAmountVar))
                    stringValueOfOrderAmountVar = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxOrderAmountVar);
            }
            if ((dirtyFlags & 0x5L) != 0) {

                    if (foodsInCart != null) {
                        // read foodsInCart.name
                        foodsInCartName = foodsInCart.getName();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cardItemName, foodsInCartName);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cardItemPrice, javaLangStringTotalStringValueOfFoodsInCartPriceOrderAmountVarJavaLangString);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.orderAmount, stringValueOfOrderAmountVar);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): foodsInCart
        flag 1 (0x2L): orderAmountVar
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}