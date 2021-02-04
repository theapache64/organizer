echo "Downloading main JAR..." &&
wget -q "https://github.com/theapache64/organizer/releases/latest/download/organizer.main.jar" -O "organizer.main.jar" --show-progress &&

echo "Moving files to ~/.organizer" &&

mkdir -p ~/.organizer &&
mv organizer.main.jar ~/.organizer/organizer.main.jar

echo "Installing..." &&
echo "\nalias organizer='java -jar ~/.organizer/organizer.main.jar'" >> ~/.bash_aliases &&

echo "Done"