package com.project.loanbook.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.project.loanbook.models.Member;

public class MemberRepository {
    public static List<Member> getAllMember(){
        List<Member> listMember = new ArrayList<>();

        Member member1 = Member.builder()
        .memberID("M-001")
        .memberName("Risman")
        .address("Bandung")
        .build();

        Member member2 = Member.builder()
        .memberID("M-002")
        .memberName("Budi")
        .address("Bandung")
        .build();

        Member member3 = Member.builder()
        .memberID("M-003")
        .memberName("Resti")
        .address("Kab. Bandung")
        .build();

        listMember.addAll(Arrays.asList(member1, member2, member3));

        return listMember;
    }
}
