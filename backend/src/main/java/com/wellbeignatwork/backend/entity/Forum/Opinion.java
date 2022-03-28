package com.wellbeignatwork.backend.entity.Forum;

import com.wellbeignatwork.backend.entity.User.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpinion;
    private String content;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User user;
}
