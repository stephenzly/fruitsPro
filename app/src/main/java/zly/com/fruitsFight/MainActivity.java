package zly.com.fruitsFight;

//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.app.FragmentManager;

public class MainActivity extends Activity implements View.OnClickListener {

    private Fragment xj = new xjFragment();
    private Fragment cz = new czFragment();
    private Fragment bl = new blFragment();
    private Fragment pt = new ptFragment();

    private LinearLayout mTabxj;
    private LinearLayout mTabcz;
    private LinearLayout mTabbl;
    private LinearLayout mTabpt;

    private ImageButton mImgxj;
    private ImageButton mImgcz;
    private ImageButton mImgbl;
    private ImageButton mImgpt;

    // fragment进行通信的通信控制器
    private FragmentManager fm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去掉APP顶部的title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initFragment();
        initView();
        // 默认选择第一个fragment
        selectFragment(0);
        initEvent();

    }

    private void initFragment() {
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
       transaction.add(R.id.id_content, xj);
        transaction.add(R.id.id_content, cz);
        transaction.add(R.id.id_content, bl);
        transaction.add(R.id.id_content, pt);
        transaction.commit();
    }


    private void initView() {
        mTabxj = (LinearLayout) findViewById(R.id.tab_x);
        mTabcz = (LinearLayout) findViewById(R.id.tab_o);
        mTabbl = (LinearLayout) findViewById(R.id.tab_b);
        mTabpt = (LinearLayout) findViewById(R.id.tab_p);

        mImgxj = (ImageButton)findViewById(R.id.x1);
        mImgcz = (ImageButton)findViewById(R.id.o1);
        mImgbl = (ImageButton)findViewById(R.id.b1);
        mImgpt = (ImageButton)findViewById(R.id.p1);

    }



    private void hideFragment(FragmentTransaction transaction) {
        transaction.hide(xj);
        transaction.hide(cz);
        transaction.hide(bl);
        transaction.hide(pt);
    }

    /**
     * 将监听范围从全屏减小至底部四个LinearLayout
     * 减少内存消耗
     */
    private void initEvent() {
        mTabxj.setOnClickListener(this);
        mTabcz.setOnClickListener(this);
        mTabbl.setOnClickListener(this);
        mTabpt.setOnClickListener(this);
    }

    /**
     * 被选择的fragment图标变色
     * @param i
     */
    private void selectFragment(int i) {
        // 先将所有图标颜色还原
//        resetImg();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i) {
            case 0:
                transaction.show(xj);
                mImgxj.setImageResource(R.drawable.x1);
                break;
            case 1:
                transaction.show(cz);
                mImgcz.setImageResource(R.drawable.o1);
                break;
            case 2:
                transaction.show(bl);
                mImgbl.setImageResource(R.drawable.b1);
                break;
            case 3:
                transaction.show(pt);
                mImgpt.setImageResource(R.drawable.p1);
                break;
            default:
                break;
        }
        transaction.commit();
    }


    @Override
    public void onClick(View v) {
//
//        mImgxj.setImageResource(R.drawable.tab_weixin_normal);
//        mImgcz.setImageResource(R.drawable.tab_find_frd_normal);
//        mImgbl.setImageResource(R.drawable.tab_address_normal);
//        mImgpt.setImageResource(R.drawable.tab_settings_normal);
        resetImg();
        // 获取当前点击的id
        switch (v.getId()) {
            case R.id.tab_x:
                selectFragment(0);
                break;
            case R.id.tab_o:
                selectFragment(1);
                break;
            case R.id.tab_b:
                selectFragment(2);
                break;
            case R.id.tab_p:
                selectFragment(3);
                break;
        }
    }

    /**
     * 将未点击的图片按钮还原成原来的颜色
     */
    public void resetImg() {
        mImgxj.setImageResource(R.drawable.x2);
        mImgcz.setImageResource(R.drawable.o2);
        mImgbl.setImageResource(R.drawable.b2);
        mImgpt.setImageResource(R.drawable.p2);
    }
}