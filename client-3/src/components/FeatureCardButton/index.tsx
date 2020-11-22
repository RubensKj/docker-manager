import React from 'react';

import { Container } from './styles';

interface CardProps {
  icon: string;
  title: string;
  description: string;
  action: () => void;
}

const FeatureCard: React.FC<CardProps> = ({ icon, title, description, action }) => {
  return (
    <Container onClick={action}>
      <img srcSet={icon} alt={title} />
      <h2>{title}</h2>
      <p>{description}</p>
    </Container>
  );
}

export default FeatureCard;