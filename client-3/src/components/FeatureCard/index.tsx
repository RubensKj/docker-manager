import React from 'react';

import { Container } from './styles';

interface CardProps {
  icon: string;
  title: string;
  description: string;
  redirectPath: string;
}

const FeatureCard: React.FC<CardProps> = ({ icon, title, description, redirectPath }) => {
  return (
    <Container href={redirectPath}>
      <img srcSet={icon} alt={title} />
      <h2>{title}</h2>
      <p>{description}</p>
    </Container>
  );
}

export default FeatureCard;