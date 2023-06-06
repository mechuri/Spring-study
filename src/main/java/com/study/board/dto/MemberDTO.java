package com.study.board.dto;
import com.study.board.entity.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String pw;
    private String name;
    private String email;

    public static MemberDTO toMemberDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setPw(member.getPw());
        memberDTO.setName(member.getName());
        memberDTO.setEmail(member.getEmail());
        return memberDTO;
    }
}
