package com.interview.graph;

import java.util.*;

public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		List<List<String>> res = new ArrayList<>();
		if (accounts.size() == 0)
			return res;
		Map<String, Set<String>> g = new HashMap<>();
		Map<String, String> mailToName = new HashMap<>();

		buildGraph(g, accounts, mailToName);

		Set<String> visited = new HashSet<>();
		for (String mail : mailToName.keySet()) {
			String name = mailToName.get(mail);
			List<String> mails = new ArrayList<>();
			if (visited.add(mail)) {
				dfs(mails, mail, g, visited);
				Collections.sort(mails);
				mails.add(0, name);
				res.add(mails);
			}
		}
		return res;

	}

	private void dfs(List<String> mails, String mail, Map<String, Set<String>> g, Set<String> visited) {
		mails.add(mail);
		if (g.get(mail).size() == 0)
			return;

		for (String neigh : g.get(mail)) {
			if (visited.add(neigh)) {
				dfs(mails, neigh, g, visited);
			}
		}
	}

	private void buildGraph(Map<String, Set<String>> g, List<List<String>> accounts, Map<String, String> mailToName) {
		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				String mail = account.get(i);
				mailToName.put(mail, name);
				g.putIfAbsent(mail, new HashSet<String>());
				if (i == 1)
					continue;
				String prev = account.get(i - 1);
				g.get(prev).add(mail);
				g.get(mail).add(prev);

			}
		}
	}
}
