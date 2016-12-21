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
import orm.fox.liteorm.db.liteorm.LiteOrmProxy;
import orm.fox.liteorm.db.liteorm.entity.User;

public class LiteOrmActivity extends AppCompatActivity {

    ListView lvDemo;

    List<User> list ;

    ItemDemoAdapter adapter;

    DbHelper dbHelper = new DbHelper(new LiteOrmProxy());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        User user = new User();
        user.name = "我"+new Random().nextLong();
        user.rule = "管理员";
        user.otherInfo = "其他";
        dbHelper.insert(user);
        list = queryList();
        adapter.setList(list);
    }


    private void onBtnDeleteClick() {
        if(list == null || list.size() == 0){
            return;
        }
        User user = list.get(0);
        dbHelper.delete(user);
        list = queryList();
        adapter.setList(list);
    }

    void onBtnUpdateClick(){
        if(list == null || list.size() == 0){
            return;
        }
        User user = list.get(0);
        user.rule = "修改的管理员";
        dbHelper.update(user);
        adapter.notifyDataSetChanged();
    }

    private List<User> queryList(){
        return dbHelper.query(User.class);
    }

    class ItemDemoAdapter extends BaseAdapter {

        private List<User> objects = new ArrayList<>();
        private LayoutInflater layoutInflater;

        public ItemDemoAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        public void setList(List<User> list){
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
        public User getItem(int position) {
            return objects.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.item_demo, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews(getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(User object, ViewHolder holder) {
            holder.tvUserId.setText(String.valueOf(object.id));
            holder.tvUserName.setText(object.name);
            holder.tvUserRule.setText(object.rule);
            holder.tvUserOther.setText(object.otherInfo);
        }

        class ViewHolder {
            TextView tvUserId;
            TextView tvUserName;
            TextView tvUserRule;
            TextView tvUserOther;

            ViewHolder(View view) {
                tvUserName = (TextView)view.findViewById(R.id.tvUserName);
                tvUserId = (TextView)view.findViewById(R.id.tvUserId);
                tvUserRule = (TextView)view.findViewById(R.id.tvUserRule);
                tvUserOther = (TextView) view.findViewById(R.id.tvUserOther);

            }
        }
    }

}
