/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtables;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dbonach
 */
public interface CourseRepository extends JpaRepository<Student, Long> {
    
}