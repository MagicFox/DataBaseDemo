package orm.fox.liteorm;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import orm.fox.liteorm.db.DbHelper;
import orm.fox.liteorm.db.greendao.GreenDaoProxy;
import orm.fox.liteorm.db.greendao.entity.BusinessReport;

/**
 * Created by MagicFox on 2016/12/20.
 */

public class GreenDaoActivity extends AppCompatActivity {


    DbHelper dbHelper = new DbHelper(new GreenDaoProxy());
    ListView lvDemo;
    List<BusinessReport> list ;
    ItemDemoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        lvDemo = (ListView) findViewById(R.id.lvDemo);

        list = queryList();
        adapter = new ItemDemoAdapter(this);
        adapter.setList(list);
        lvDemo.setAdapter(adapter);

        findViewById(R.id.btnAdd).setOnClickListener(onClickListener);
        findViewById(R.id.btnUpdate).setOnClickListener(onClickListener);
        findViewById(R.id.btnDelete).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnAdd:
                    onBtnAddClick();
                    break;
                case R.id.btnUpdate:
                    onBtnUpdateClick();
                    break;
                case R.id.btnDelete:
                    onBtnDeleteClick();
                    break;
            }
        }

    };

    void onBtnAddClick() {
        BusinessReport user = new BusinessReport();
        user.setEmployee("我"+new Random().nextLong());
        user.setCustomer("客户");
        user.setCity("上海");
        dbHelper.insert(user);
        list = queryList();
        adapter.setList(list);
    }


    private void onBtnDeleteClick() {
        if(list == null || list.size() == 0){
            return;
        }
        BusinessReport user = list.get(0);
        dbHelper.delete(user);
        list = queryList();
        adapter.setList(list);
    }

    void onBtnUpdateClick(){
        if(list == null || list.size() == 0){
            return;
        }
        BusinessReport user = list.get(0);
        user.setEmployee("修改的员工");
        dbHelper.update(user);
        adapter.notifyDataSetChanged();
    }

    private List<BusinessReport> queryList(){
        return dbHelper.query(BusinessReport.class);
    }


    class ItemDemoAdapter extends BaseAdapter {

        private List<BusinessReport> objects = new ArrayList<>();
        private LayoutInflater layoutInflater;

        public ItemDemoAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        public void setList(List<BusinessReport> list){
            if(list == null){
                list = new ArrayList<>();
            }
            this.objects = list;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return objects.size();
        }

        @Override
        public BusinessReport getItem(int position) {
            return objects.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.item_report, null);
                convertView.setTag(new ItemDemoAdapter.ViewHolder(convertView));
            }
            initializeViews(getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(BusinessReport object, ViewHolder holder) {
            holder.tvId.setText(String.valueOf(object.getId()));
            holder.tvEmployee.setText(object.getEmployee());
            holder.tvCustomer.setText(object.getCustomer());
            holder.tvCity.setText(object.getCity());
        }

        class ViewHolder {
            TextView tvId;
            TextView tvEmployee;
            TextView tvCustomer;
            TextView tvCity;

            ViewHolder(View view) {
                tvId = (TextView)view.findViewById(R.id.tvId);
                tvEmployee = (TextView)view.findViewById(R.id.tvEmployee);
                tvCustomer = (TextView)view.findViewById(R.id.tvCustomer);
                tvCity = (TextView) view.findViewById(R.id.tvCity);

            }
        }
    }
}
