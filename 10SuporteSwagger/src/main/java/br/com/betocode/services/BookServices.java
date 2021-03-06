package br.com.betocode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.betocode.converter.DozerConverter;
import br.com.betocode.data.model.Book;
import br.com.betocode.data.vo.BookVO;
import br.com.betocode.exception.ResourceNotFoundException;
import br.com.betocode.repository.BookRepository;

@Service
public class BookServices {

	@Autowired
	BookRepository repository;
	
	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public List<BookVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
    }
	
	public BookVO findById(Long id) {
		
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	public BookVO update(BookVO book) {	
		var entity = repository.findById(book.getKey()).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());	
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerConverter.parseObject(entity, BookVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Book entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		repository.delete(entity);
	}
	
}

	
	
	

