package com.study.board.service;
import com.study.board.dto.MemberDTO;
import com.study.board.entity.Member;
import com.study.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    @Autowired
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        // repository의 save 메서드 호출 (조건: entity 객체를 넘겨줘야 함)
        Member member = Member.toMemberEntity(memberDTO);
        memberRepository.save(member);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        // 1. 회원이 입력한 이름으로 DB 조회
        // 2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 이리하는지 판단

        Optional<Member> byName = memberRepository.findByName(memberDTO.getName());
        if (byName.isPresent()) {
            //  조회 결과가 있음
            Member member = byName.get();
            if (member.getPw().equals(memberDTO.getPw())) {
                // 비밀번호 일치
                // entity 객체 dto로 변환 후 return
                MemberDTO dto = MemberDTO.toMemberDTO(member);
                return dto;
            }
            else {
                // 비밀번호 불일치
                return null;
            }

        }
        else {
            // 조회 결과가 없음
            return null;
        }
    }
}
