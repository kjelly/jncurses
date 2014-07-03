import com.sun.jna.Pointer;
import ncurses4j.NCurses;

object Hi{
  val stdscr:Pointer = NCurses.initscr()
  def init():Unit = {
    if (NCurses.has_colors()) {
        NCurses.start_color();
        if (NCurses.COLOR_PAIRS() > 1) {
            NCurses.init_pair(1, NCurses.COLOR_BLACK, NCurses.COLOR_WHITE)
            NCurses.attron(NCurses.COLOR_PAIR(1))
        }
        NCurses.attron(NCurses.A_BOLD);
    }
  }
  def main(args: Array[String]):Unit = {
    init()
    NCurses.erase()
    NCurses.mvprintw(0, 0, "Hi!")
    NCurses.getch()
    NCurses.endwin()
  }
}
