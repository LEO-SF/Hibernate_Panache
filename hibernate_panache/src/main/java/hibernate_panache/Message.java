package hibernate_panache;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class Message extends PanacheEntity {
    
    private String text;

    public Message() {
    }

    public Message(String text) {

        this.setText(text);
    }


    public String getText() {
        return this.text;
    }

    private void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message: " + this.getText();
    }
}