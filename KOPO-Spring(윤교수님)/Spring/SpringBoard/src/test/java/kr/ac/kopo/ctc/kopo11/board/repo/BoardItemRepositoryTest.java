//package kr.ac.kopo.ctc.kopo11.board.repo;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import jakarta.transaction.Transactional;
//import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
//
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class BoardItemRepositoryTest {
//
//	@Autowired
//	private BoardItemRepository boardItemRepository;
//
//	@Test
//	@Transactional
//	public void oneToMany_OneWay() {
//	// 미리 아이템 100개를 적재
//	for(int i = 0 ; i < 100; i++){
//	BoardItem be = new BoardItem();
//	be.setContent(dummyString());
//	if( i % 3 == 0 ){
//	be.setAuthor("first");
//	}
//	else if( i % 3 == 1 ) {
//	be.setAuthor("second");
//	}
//	else {
//	be.setAuthor("third");
//	}
//	boardItemRepository.save(be);
//	}
//
//	// 한 페이지 아이템 10개, 0번째 페이지 호출
//	Page<BoardItem> page = boardItemRepository.findAll(PageRequest.of(0, 10));
//	printPageData("simple", page);
//
//	// 한 페이지 아이템 10개, 글번호 내림차순으로, 0번째 페이지 호출
//	page = boardItemRepository.findAllByOrderByIdDesc(PageRequest.of(0, 10));
//	printPageData("sort_seq_desc", page);
//
//	// 한 페이지에 아이템 10개, 글번호 내림차순으로, 2번째 페이지 호출
//	page = boardItemRepository.findAll(PageRequest.of(2, 10, new Sort(Direction.DESC, "id")));
//	printPageData("sort", page);
//
//	// 한페이지에 아이템 10개, 글작성자 "first", 0번째 페이지 호출
//	page = boardItemRepository.findAllByAuthor("first", PageRequest.of(0, 10));
//	printPageData("sort_author", page);
//
//	// 한페이지 아이템 10개, 작성자 내림차순으로, 2번째 페이지 호출
//	page = boardItemRepository.findAll(PageRequest.of(2, 10, new Sort(Direction.DESC, "author")));
//	printPageData("sort_author_desc", page);
//
//	// 한페이지 아이템 10개, 검색어 중, 글번호 내림차순으로, 2번째 페이지 호출
//	page = boardItemRepository.findAllSearch("bc", PageRequest.of(2, 10, new Sort(Direction.DESC, "id")));
//	printPageData("sort_search_desc", page);
//	}
//
//	// 페이지 데이터 출력
//	private void printPageData(String label, Page<BoardItem> page){
//	if( page == null || page.getSize() <= 0 ) return;
//
//	for( int i = 0 ; i < page.getSize(); i++ ){
//	BoardItem be = page.getContent().get(i);
//	System.out.println("["+label+"] "+ be.getId() + " " + be.getAuthor() + " " + be.getContent());
//	}
//	}
//
//	// 더미 문자열 반환
//	private String dummyString(){
//
//	String [] dummy = {"abc", "bcd", "cde", "def"};
//	int rand = (int)(System.currentTimeMillis() % dummy.length);
//
//	return dummy[rand];
//	}
//
//	}
