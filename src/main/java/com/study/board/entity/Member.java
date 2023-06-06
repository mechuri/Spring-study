package com.study.board.entity;
import com.study.board.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;
    private String pw;
    private String name;
    private String email;

    public static Member toMemberEntity(MemberDTO memberDTO){
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setPw(memberDTO.getPw());
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        return member;
    }
}