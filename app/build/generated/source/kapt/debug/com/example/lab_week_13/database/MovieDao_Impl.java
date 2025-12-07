package com.example.lab_week_13.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.lab_week_13.model.Movie;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Movie> __insertionAdapterOfMovie;

  public MovieDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovie = new EntityInsertionAdapter<Movie>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `movies` (`adult`,`backdrop_path`,`id`,`originalLanguage`,`originalTitle`,`overview`,`popularity`,`posterPath`,`releaseDate`,`title`,`video`,`voteAverage`,`voteCount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Movie entity) {
        final int _tmp = entity.getAdult() ? 1 : 0;
        statement.bindLong(1, _tmp);
        if (entity.getBackdrop_path() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getBackdrop_path());
        }
        statement.bindLong(3, entity.getId());
        if (entity.getOriginalLanguage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getOriginalLanguage());
        }
        if (entity.getOriginalTitle() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getOriginalTitle());
        }
        if (entity.getOverview() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getOverview());
        }
        statement.bindDouble(7, entity.getPopularity());
        if (entity.getPosterPath() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPosterPath());
        }
        if (entity.getReleaseDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getReleaseDate());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getTitle());
        }
        final int _tmp_1 = entity.getVideo() ? 1 : 0;
        statement.bindLong(11, _tmp_1);
        statement.bindDouble(12, entity.getVoteAverage());
        statement.bindLong(13, entity.getVoteCount());
      }
    };
  }

  @Override
  public void addMovies(final List<Movie> movies) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovie.insert(movies);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Movie> getMovies() {
    final String _sql = "SELECT * FROM movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAdult = CursorUtil.getColumnIndexOrThrow(_cursor, "adult");
      final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "originalLanguage");
      final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "originalTitle");
      final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
      final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
      final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "posterPath");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
      final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "voteAverage");
      final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "voteCount");
      final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Movie _item;
        final boolean _tmpAdult;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAdult);
        _tmpAdult = _tmp != 0;
        final String _tmpBackdrop_path;
        if (_cursor.isNull(_cursorIndexOfBackdropPath)) {
          _tmpBackdrop_path = null;
        } else {
          _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
        }
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpOriginalLanguage;
        if (_cursor.isNull(_cursorIndexOfOriginalLanguage)) {
          _tmpOriginalLanguage = null;
        } else {
          _tmpOriginalLanguage = _cursor.getString(_cursorIndexOfOriginalLanguage);
        }
        final String _tmpOriginalTitle;
        if (_cursor.isNull(_cursorIndexOfOriginalTitle)) {
          _tmpOriginalTitle = null;
        } else {
          _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
        }
        final String _tmpOverview;
        if (_cursor.isNull(_cursorIndexOfOverview)) {
          _tmpOverview = null;
        } else {
          _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        }
        final float _tmpPopularity;
        _tmpPopularity = _cursor.getFloat(_cursorIndexOfPopularity);
        final String _tmpPosterPath;
        if (_cursor.isNull(_cursorIndexOfPosterPath)) {
          _tmpPosterPath = null;
        } else {
          _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
        }
        final String _tmpReleaseDate;
        if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
          _tmpReleaseDate = null;
        } else {
          _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        }
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final boolean _tmpVideo;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfVideo);
        _tmpVideo = _tmp_1 != 0;
        final float _tmpVoteAverage;
        _tmpVoteAverage = _cursor.getFloat(_cursorIndexOfVoteAverage);
        final int _tmpVoteCount;
        _tmpVoteCount = _cursor.getInt(_cursorIndexOfVoteCount);
        _item = new Movie(_tmpAdult,_tmpBackdrop_path,_tmpId,_tmpOriginalLanguage,_tmpOriginalTitle,_tmpOverview,_tmpPopularity,_tmpPosterPath,_tmpReleaseDate,_tmpTitle,_tmpVideo,_tmpVoteAverage,_tmpVoteCount);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
