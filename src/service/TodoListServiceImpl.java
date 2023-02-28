package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {

        Todolist[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");
        var number = 1;
        for(var i = 0; i < model.length; i++) {

            if(model[i] != null) {
                System.out.println(number + ". "+ model[i].getTodo());
                number++;
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("SUKSES MENAMBAH TODO : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if(success) {
            System.out.println("Berhasil Menghapus Todo : " + number);
        } else {
            System.out.println("Gagal Mengapus Todo : " + number);
        }

    }
}
