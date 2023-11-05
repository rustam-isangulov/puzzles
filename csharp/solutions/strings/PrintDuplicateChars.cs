namespace solutions;

public class PrintDuplicateChars
{
	public List<(char c, int count)> GetDuplicateCounts(string input)
	{
		var charDuplicateCounter =
			from c in input
			group c by c into gr
			where gr.Count() > 1
			select (ch: gr.Key, count: gr.Count());

		return charDuplicateCounter.ToList();
	}
}
