
set names=spencer adam drew tj

git checkout master
git pull

for %%i in (%names%) do (
    echo updating %%i
    git checkout %%i
    git merge master
    git push
)
