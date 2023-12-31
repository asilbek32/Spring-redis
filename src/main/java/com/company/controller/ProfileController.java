package com.company.controller;

import com.company.dto.ProfileDTO;
import com.company.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile_redis")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("")
    public ProfileDTO post(@RequestBody ProfileDTO dto) {
        return profileService.create(dto);
    }

    @GetMapping("/{id}")
    public ProfileDTO get(@PathVariable("id") Integer id) {
        return profileService.get(id);
    }

    @GetMapping("")
    public List<ProfileDTO> all() {
        return profileService.list();
    }

    @PutMapping("/{id}")
    public ProfileDTO update(@PathVariable("id") Integer id, @RequestBody ProfileDTO dto) {
        return profileService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        profileService.delete(id);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        profileService.deleteAll();
    }
}
