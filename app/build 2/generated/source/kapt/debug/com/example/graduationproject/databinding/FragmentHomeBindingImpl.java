package com.example.graduationproject.databinding;
import com.example.graduationproject.R;
import com.example.graduationproject.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView2, 3);
        sViewsWithIds.put(R.id.imageView5, 4);
        sViewsWithIds.put(R.id.searchView, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.SearchView) bindings[5]
            , (android.widget.TextView) bindings[3]
            );
        this.categoriesRV.setTag(null);
        this.foodsRV.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.adapter == variableId) {
            setAdapter((com.example.graduationproject.ui.adapter.FoodsAdapter) variable);
        }
        else if (BR.categoriesAdapter == variableId) {
            setCategoriesAdapter((com.example.graduationproject.ui.adapter.CategoriesAdapter) variable);
        }
        else if (BR.homeFragment == variableId) {
            setHomeFragment((com.example.graduationproject.ui.fragments.HomeFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAdapter(@Nullable com.example.graduationproject.ui.adapter.FoodsAdapter Adapter) {
        this.mAdapter = Adapter;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }
    public void setCategoriesAdapter(@Nullable com.example.graduationproject.ui.adapter.CategoriesAdapter CategoriesAdapter) {
        this.mCategoriesAdapter = CategoriesAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.categoriesAdapter);
        super.requestRebind();
    }
    public void setHomeFragment(@Nullable com.example.graduationproject.ui.fragments.HomeFragment HomeFragment) {
        this.mHomeFragment = HomeFragment;
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
        com.example.graduationproject.ui.adapter.FoodsAdapter adapter = mAdapter;
        com.example.graduationproject.ui.adapter.CategoriesAdapter categoriesAdapter = mCategoriesAdapter;

        if ((dirtyFlags & 0x9L) != 0) {
        }
        if ((dirtyFlags & 0xaL) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            this.categoriesRV.setAdapter(categoriesAdapter);
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            this.foodsRV.setAdapter(adapter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): adapter
        flag 1 (0x2L): categoriesAdapter
        flag 2 (0x3L): homeFragment
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}