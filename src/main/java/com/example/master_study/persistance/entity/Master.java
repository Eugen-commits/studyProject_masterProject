package com.example.master_study.persistance.entity;

import com.example.master_study.persistance.enums.Districts;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "master_skill",
            joinColumns = {@JoinColumn(name = "master_id")},
            inverseJoinColumns = {@JoinColumn (name = "skill_id")}
    )
    private Set <Skill> skills;

    @Column(nullable = false)
    @Enumerated (EnumType.STRING)
    private Districts district;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Master)) return false;
        Master master = (Master) o;
        return
                Objects.equals(name, master.name) &&
                Objects.equals(skills, master.skills) &&
                Objects.equals(district, master.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skills, district);
    }
}
