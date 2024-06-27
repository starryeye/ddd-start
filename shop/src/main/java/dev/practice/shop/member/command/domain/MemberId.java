package dev.practice.shop.member.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class MemberId implements Serializable {

    @Column(name = "member_id")
    private String id;

    @Builder
    private MemberId(String id) {
        this.id = id;
    }

    public static MemberId of(String id) {
        return MemberId.builder()
                .id(id)
                .build();
    }
}
