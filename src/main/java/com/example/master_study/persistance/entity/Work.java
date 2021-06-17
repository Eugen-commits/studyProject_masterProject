package com.example.master_study.persistance.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "work_skill",
            joinColumns = {@JoinColumn (name = "work_id")},
            inverseJoinColumns = {@JoinColumn (name = "skill_id")}
    )
    private Set<Skill> skill;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Work)) return false;
        Work work = (Work) o;
        return Objects.equals(id, work.id) &&
                Objects.equals(skill, work.skill) &&
                Objects.equals(price, work.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill, price);
    }
}
