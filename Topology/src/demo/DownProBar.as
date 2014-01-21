package demo
{
	import mx.preloaders.DownloadProgressBar;

	public class DownProBar extends DownloadProgressBar
	{
		public function DownProBar()
		{
			super();
//			downloadingLabel="正在下载中...";
			initializingLabel="正在初始化内容...";
		}
	}
}