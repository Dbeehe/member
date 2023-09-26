package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.entity.MemberEntity;
import com.icia.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        Long savedId = memberRepository.save(memberEntity).getId();
        return savedId;
    }

    public boolean login(MemberDTO memberDTO) {
        /*
            DB에서 로그인하는 사용자의 이메일로 죄회한 결과를 가져와서
            비밀번호가 일치하는지 비교한 뒤 로그인 성공 여부를 판단

            findByMemberEmail()
            select * from member_table where id = ?

            findById()
            => select * from member_table where  id = ?
         */
        // 1.
//        memberRepository.findByMemberEmail(memberDTO.getMemberEmail())
//                        .orElseThrow(() -> new NoSuchElementException());
        // 2. email, password 둘다 만족하는 조회결과가 있다면 로그인성공, 없다면 로그인 실패
        Optional<MemberEntity> optionalMemberEntity =
                memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(optionalMemberEntity.isPresent()){
//            MemberEntity memberEntity = optionalMemberEntity.get();
            return true;
        }else {
            return false;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity memberEntity: memberEntityList){
//            MemberDTO memberDTO = MemberDTO.toDTO(memberEntity);
//            memberDTOList.add(memberDTO);
            // 한줄로
            memberDTOList.add(MemberDTO.toDTO(memberEntity));
        }
        return memberDTOList;
    }
}












