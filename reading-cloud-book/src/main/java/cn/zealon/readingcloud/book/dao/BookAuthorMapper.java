package cn.zealon.readingcloud.book.dao;

import cn.zealon.readingcloud.common.pojo.book.BookAuthor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图书作者
 * @author: tangyl
 * @since: 2020/3/14
 */
public interface BookAuthorMapper {

    List<BookAuthor> findPageWithResult(@Param("name") String name);

    Integer findPageWithCount(String name);
}
