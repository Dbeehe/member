package com.example.member.entity;

import com.example.member.dto.MemberDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String member_email;

    @Column(length = 20, nullable = false)
    private String member_password;

    @Column(length = 20, nullable = false)
    private String member_name;

    @Column(length = 20)
    private String member_birth;

    @Column(length = 30)
    private String member_mobile;



    // DTO -> Entity
    public static MemberEntity toSaveEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMember_email(memberDTO.getMemberEmail());
        memberEntity.setMember_password(memberDTO.getMemberPassword());
        memberEntity.setMember_name(memberDTO.getMemberName());
        memberEntity.setMember_birth(memberDTO.getMemberBirth());
        memberEntity.setMember_mobile(memberDTO.getMemberMobile());
        return memberEntity;
    }
    public static MemberEntity toUpdateEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMember_email(memberDTO.getMemberEmail());
        memberEntity.setMember_password(memberDTO.getMemberPassword());
        memberEntity.setMember_name(memberDTO.getMemberName());
        memberEntity.setMember_birth(memberDTO.getMemberBirth());
        memberEntity.setMember_mobile(memberDTO.getMemberMobile());
        return memberEntity;
    }

}
