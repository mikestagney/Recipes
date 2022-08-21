package recipes;

import javax.persistence.*;

@Entity
@Table(name = "directions")
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direction_id")
    int id;

    @Column(name = "direction_name")
    String name;



}
