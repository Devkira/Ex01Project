package com.devlink.test.springboot.web;

import com.devlink.test.springboot.service.PostsService;
import com.devlink.test.springboot.web.dto.PostsResponseDto;
import com.devlink.test.springboot.web.dto.PostsSaveRequestDto;
import com.devlink.test.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @DeleteMapping("/api/v1/posts/{id}")
    public Long del(@PathVariable Long id) {
        postsService.del(id);
        return id;
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
