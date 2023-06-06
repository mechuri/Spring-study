package com.study.board.repository;

import com.study.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이메일로 회원 정보 조회 (select * from member where name)
    Optional<Member> findByName(String name);
}
