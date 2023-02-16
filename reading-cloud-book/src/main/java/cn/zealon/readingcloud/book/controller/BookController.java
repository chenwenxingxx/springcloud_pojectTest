package cn.zealon.readingcloud.book.controller;

import cn.zealon.readingcloud.book.service.BookService;
import cn.zealon.readingcloud.book.vo.BookVO;
import cn.zealon.readingcloud.common.pojo.book.Book;
import cn.zealon.readingcloud.common.result.Result;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 图书接口
 * @author: zealon
 * @since: 2019/4/3
 */
@Api(description = "图书查询接口")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "查询图书基本信息" , httpMethod = "GET")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "bookId", value = "图书ID", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 200, message = "", response = Book.class)})
    @GetMapping("/getBookById")
    public Result<Book> getBookById(String bookId){
        return bookService.getBookById(bookId);
    }

    @ApiOperation(value = "获取图书详情" , httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookId", value = "图书ID", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 200, message = "", response = Book.class)})
    @SentinelResource(value = "details")
    @GetMapping("/details")
    public Result<BookVO> getBookDetails(String bookId){
        return bookService.getBookDetails(bookId);
    }


    @RequestMapping("/bookList")
    public String getBookList(){
        List<BookVO> bookList = bookService.getBookList();
        return JSONObject.toJSONString(bookList);
    }




}
