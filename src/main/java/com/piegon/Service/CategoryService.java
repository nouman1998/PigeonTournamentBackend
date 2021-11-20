package com.piegon.Service;

import com.piegon.DTO.CategoryDTO;
import com.piegon.DTO.TournamentDTO;
import com.piegon.Models.Category;
import com.piegon.Models.Tournament;
import com.piegon.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {

        CategoryDTO categoryDTO;
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        try {
            List<Category> categories = this.categoryRepository.findAll();
            if (categories != null && categories.size() > 0) {
                for (Category category : categories) {
                    categoryDTO = new CategoryDTO();
                    categoryDTO.populateDTO(category);
                    categoryDTOS.add(categoryDTO);

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return categoryDTOS;

    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {

        try {
            if (categoryDTO.getCategoryName() == null) {
                throw new HttpServerErrorException(HttpStatus.BAD_REQUEST);
            }
            Category category = categoryDTO.populateDomainObject();
            this.categoryRepository.save(category);
            return categoryDTO;

        } catch (Exception e) {
            System.out.println(e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public CategoryDTO findById(Long id) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if (id == null || id == 0) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST);
        }
        Optional<Category> category = this.categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryDTO.populateDTO(category.get());
            return  categoryDTO;
        }
        else {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }

    }
    public List<TournamentDTO> findByCategoryId(Long categoryId) {
        List<TournamentDTO> tournamentDTOS = new ArrayList<>();
        try{
           Optional <Category> category = this.categoryRepository.findById(categoryId);
            if(category.isPresent())
            { TournamentDTO tournamentDTO;
                if(category.get().getTournaments().size()>0)
                {
                   for(Tournament tournament : category.get().getTournaments())
                   {
                       tournamentDTO = new TournamentDTO();
                       tournamentDTO.populateDTO(tournament);
                       tournamentDTOS.add(tournamentDTO);
                   }
                }
            }
            return tournamentDTOS;
        }
        catch (Exception e)
        {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
