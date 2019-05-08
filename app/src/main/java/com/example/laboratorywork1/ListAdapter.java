package com.example.laboratorywork1;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


// необходим для связи элементов java с view для списка
//адаптер наследубется от RecyclerAdapter
//привязываем к собственному Холдеру для доступа к компонентам View
public class ListAdapter extends android.support.v7.widget.RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    public NumberWords numberWords;
    int sizeList = 1000000;

    public ListAdapter(){
        super();
        numberWords = new NumberWords();
    }

    //предоставляет прямые ссылки на каждый view компонент
    public static class ListViewHolder extends RecyclerView.ViewHolder{
        // создание переменных для всех компонентов списка
        public View itemList;

        public ListViewHolder(View itemList) {
            super(itemList);
            this.itemList = itemList;
        }
    }

    @Override
    //переопределяется метод для создания объекта вьюХолдер
    //в конструктор передается созданный вьюКомпонент (itemList)
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent,false);
        return new ListViewHolder(itemList);
    }

    @Override
    //связь кода объекта и вью
    public void onBindViewHolder(ListViewHolder holder, int position){
        String color = ((position + 1) % 2 == 0) ? "#CCCCCC" : "#FFFFFF";
        holder.itemList.setBackgroundColor(Color.parseColor(color));
        TextView textView = (TextView)holder.itemList.findViewById(R.id.textList);
        textView.setText((numberWords.getNumberInWords(position + 1)));
    }

    @Override
    // сообщает и возвращает кол-во элементов в списке
    public int getItemCount(){
        return sizeList;
    }
}
