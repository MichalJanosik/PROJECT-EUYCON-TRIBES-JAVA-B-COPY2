package com.example.projecteucyonjavatribesb.model;

import com.example.projecteucyonjavatribesb.model.Troops.Troops;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Kingdom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "kingdom", cascade = CascadeType.ALL)
    private Location location;
    private String ruler;
    private Integer population;
    @OneToOne
    private Player player;
    @OneToMany(mappedBy = "kingdom", cascade = CascadeType.ALL)
    private List<Resources> resourcesList = new ArrayList<>();
    @OneToMany(mappedBy = "kingdom", cascade = CascadeType.ALL)
    private List<Buildings> buildingList = new ArrayList<>();
    @OneToMany(mappedBy = "kingdom", cascade = CascadeType.ALL)
    private List<Troops> troopsList = new ArrayList<>();

    public Kingdom(String ruler, Integer population, Location location){
        this.ruler = ruler;
        this.population = population;
        this.location = location;
    }
    public Kingdom(Long id, String ruler, Integer population, Location location) {
        this.id = id;
        this.ruler = ruler;
        this.population = population;
        this.location = location;
    }

    public Kingdom(String ruler) {
        this.ruler = ruler;
        this.population = 0;
    }
}
