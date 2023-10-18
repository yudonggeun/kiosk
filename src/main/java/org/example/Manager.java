package org.example;

import org.example.domain.Menu;
import org.example.domain.State;

public class Manager {

    private State state;

    public Manager(Menu main) {
        this.state = State.context();
        state.setMenu(main);
    }

    public void print(){
        state.print();
    }

    public void run(String command){
        try {
            state.run(command);
        } catch (RuntimeException ex){
            System.out.println("입력을 다시해주세요.");
        }
    }
}