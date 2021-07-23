/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapplication;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dbonach
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int checked;
    
    public Task(String name) {
        this.name = name;
        this.checked = 0;
    }
    
    public void addOne() {
        this.checked++;
    }
}
