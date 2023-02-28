package repository;

import entity.Todolist;

public class TodoListRepositoryImpl implements TodoListRepository{

    public Todolist[] data = new Todolist[10];
    @Override
    public Todolist[] getAll() {
        return data;
    }

    // THIS METHOD FOR ADD METHOD
    public boolean isFull() {
        // check jika model penuh atau tidak
        boolean isFull = true;
        for(var i = 0; i < data.length; i++) {
            if(data[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull() {
        // jika penuh tambah ukuran model sebanyak 2 kali lipat dari ukuran awal
        if(isFull()) {
            var temp = data;
            data = new Todolist[data.length * 2];

            for(var i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(Todolist todolist) {
        resizeIfFull();

        // tambahkan data ke dalam array yang null
        for(var i = 0; i < data.length; i++) {
            if(data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
