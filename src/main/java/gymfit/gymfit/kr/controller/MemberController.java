package gymfit.gymfit.kr.controller;

import gymfit.gymfit.kr.model.Member;
import gymfit.gymfit.kr.service.MemberService;
import gymfit.gymfit.kr.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = memberService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + id));
        return ResponseEntity.ok(member);
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member savedMember = memberService.save(member);
        return ResponseEntity.ok(savedMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        Member member = memberService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + id));

        member.setName(memberDetails.getName());
        member.setGender(memberDetails.getGender());
        member.setHeight(memberDetails.getHeight());
        member.setPhone(memberDetails.getPhone());
        member.setEmail(memberDetails.getEmail());
        member.setWeight(memberDetails.getWeight());
        member.setMemberId(memberDetails.getMemberId());
        member.setMemberGroup(memberDetails.getMemberGroup());
        member.setBmi(memberDetails.getBmi());
        member.setHandler(memberDetails.getHandler());
        member.setEnterAlarm(memberDetails.getEnterAlarm());
        member.setAddress(memberDetails.getAddress());
        member.setMemo(memberDetails.getMemo());
        member.setProfileImage(memberDetails.getProfileImage());

        Member updatedMember = memberService.save(member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        Member member = memberService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + id));
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
