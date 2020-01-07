# Group-4
CS 499 - Senior Design Project

## Cloning the repository to your local machine
Ensure that you have the necessary `git` commands installed. If not, https://git-scm.com/downloads
If you want a GUI Git client, you can choose which you want.
Once you have a folder for Git repos, clone the repo to it with `git clone https://github.com/Bowen-SW/Group-4.git`
Open the folder it clones to, and run `git checkout <your-branch>` 
Make sure to keep your branch up to date with the remote server with `git pull`

## Creating git commits on your branch
Once your branch has changed files, stage the changes with `git add *` for all changes or change the `*` to any specific file(s) you want to commits.
When all your changes are staged, use `git commit -m "Your commit message here"` to commit them to your local branch.
Then, push to the remote server with `git push`. If you've created a new branch, you can link it to a new remote branch with `git push --set-upstream origin/<new-branch>`.

## Updating your branch from master
The following will pull changes from `origin/master` to your local `master` branch, then copy those changes to `<your-branch>`.
```
git checkout master
git pull
git checkout <your-branch>
git merge master
git push
```

## Updating all branches after a successful pull request
Make sure that you have no local changes on any of the five main branches before attempting this as merge conflicts will almost definitely happen if you do.
To update all branches from master, run the `update_branches.bat` file.
If you can't run batch files, the commands are
```
git checkout master
git pull

git checkout spencer
git merge master
git push
...
```
Repeat the bottom three lines for each branch.
